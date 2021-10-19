# Hello Protobuf - Face Me! 


```bash
# build with protoc
protoc --proto_path=. --java_out=./build/java --python_out=./build/python ./protobuf/shopping.proto


# WIP:
# protoc -I=$SRC_DIR --java_out=$DST_DIR --kotlin_out=$DST_DIR $SRC_DIR/addressbook.proto
# protoc -I=./protobuf --java_out=. --kotlin_out=. ./protobuf/shopping.proto
# protoc -I=./protobuf --java_out=./protobuf-out --kotlin_out=./protobuf-out ./protobuf/shopping.proto
# protoc -I=./protobuf --java_out=./protobuf-out/java --kotlin_out=./protobuf-out/kotlin ./protobuf/shopping.proto
# protoc --proto_path=src --java_out=build/gen/java --kotlin_out=build/gen/kotlin src/foo.proto
```

