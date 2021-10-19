# Hello Protobuf - Face Me! 
- File-Format/Library to serialize structured data
- developed by Google, free and open-source
- cross-plattform: supports C++, C#, Dart, Go, Java, Kotlin, Python
- goal
    - faster and smaller than XML
    - uses a binary format
- similar technologies
    - Apache Thrift
    - Ion (Amazon)
    - Microsoft Bond protocols
- different Versions
    - proto2
    - proto3

## How does it work?
![image info](./img/protobuf_1.png)
1. Use the interface-description language to describ the structure of your data in a *.proto* file.
2. Generator creates source-code from that description for serializing and deserializing your data, in a specified language.
```bash
# build with protoc
protoc --proto_path=. --java_out=./build/java --python_out=./build/python ./protobuf/shopping.proto
```

3. Use the code in your application together with the protobuf API to access the data.


## Interface-Description Language, .proto-file

Example 1: 
```
syntax = "proto3";              // polyline.proto

message SearchRequest {         // message definition
  string query = 1;             // type name = unique tag
  int32 page_number = 2;            
  int32 result_per_page = 3;
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


Example 2:
```proto
syntax = "proto3";   

// options
option optimize_for = CODE_SIZE;
option java_multiple_files = true;
...

message SearchResponse {
  repeated Result results = 1;
}

message Result {
  string url = 1;
  string title = 2;
  repeated string snippets = 3;
}
```

## Extending a protocol buffer over time
Extension in general is supported.
- you must not change the tag number of any existing fields
- you must not add or delete any required fileds
- you may delete optional or repeated fields
- you may add new optional or repeated fields but must use fresh tag numbers(i.e. tag numbers that were never used in this protocol buffer, not even by deleted fields.)

## Message Binary Format
https://developers.google.com/protocol-buffers/docs/encoding


## Helpful Links
Docs: https://developers.google.com/protocol-buffers/docs/proto3
Code-Style: https://developers.google.com/protocol-buffers/docs/style
