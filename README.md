# Hello Protobuf - A short introduction

## What?
- Protobuf is a File-Format/Library to serialize structured data
- developed by Google, free and open-source
- supports C++, C#, Dart, Go, Java, Kotlin, Python
- uses a binar format with the goal to be smaller and faster than e.g. XML
- similar technologies
    - Apache Thrift
    - Ion (Amazon)
    - Microsoft Bond protocols
- there are different Versions with different syntax and functionality
    - proto2
    - proto3

## How?
![image info](./doc/res/protobuf_1.png)
1. Use the interface-description language to describ the structure of your data in a *.proto* file.
2. Generator creates source-code from that description for serializing and deserializing your data, in a specified language.
```bash
# build with protoc
protoc --proto_path=. --java_out=./build/java --python_out=./build/python ./protobuf/shopping.proto
```
3. Use the code in your application together with the protobuf API to access the data.

## Interface-Description Language (.proto file)

**Example 1:**
```
syntax = "proto3";              // polyline.proto

message Item {                  // message definition
    string name = 1;            // type name = unique tag
    int32 amount = 2;
}

// line comment
/* block comment */
```

**tag**
- used to identify your fields in the message binary format
- should not be changed once message type is used
- 1 to 15, one byte
- 16 to 2047, two bytes
- 19000 to 19999 cannot be used

**field rules / modifiers**
- singular (default):
- repeated: 
    - field can be repeated any number of times (including zero), 
    - the order will be preserved
    - uses packed encoding
- reserved:
    - show that tag or name has already benn used, but was deleted

default values, when a message does not contain a particular singular element
- string: empty string
- bytes: empty bytes
- bools: false
- numberic: 0
- enums: 0


**Example 2:**
```proto
syntax = "proto3";   

// options
option optimize_for = CODE_SIZE;
option java_multiple_files = true;
...

message ShoppingList {
    repeated Item items = 1;
}

message Item {
    string name = 1;
    int32 amount = 2;
}
```

**Extension of a .proto-file over time is supported, but:**
- you must not change the tag number of any existing fields
- you must not add or delete any required fileds
- you may delete optional or repeated fields
- you may add new optional or repeated fields but must use fresh tag numbers(i.e. tag numbers that were never used in this protocol buffer, not even by deleted fields.)

## Helpful Links
- Binary format explanation: https://developers.google.com/protocol-buffers/docs/encoding
- Docs: https://developers.google.com/protocol-buffers/docs/proto3
- Code-Style: https://developers.google.com/protocol-buffers/docs/style
