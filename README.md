# 


```
protoc -I=$SRC_DIR --java_out=$DST_DIR --kotlin_out=$DST_DIR $SRC_DIR/addressbook.proto


protoc -I=./protobuf --java_out=. --kotlin_out=. ./protobuf/shopping.proto

protoc -I=./protobuf --java_out=./protobuf-out --kotlin_out=./protobuf-out ./protobuf/shopping.proto
```