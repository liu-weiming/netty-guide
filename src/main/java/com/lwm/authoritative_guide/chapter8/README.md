### Google Protobuf
#### 优点
* 谷歌内部长期使用，产品成熟度高
* 跨语言（C++、Java、Python）
* 消息报文小，有利于存储和传输
* 编解码性能高
* 支持不同协议版本，前向兼容
* 支持定义可选、必选字段

#### 半包处理
* 使用ProtobufVarint32FrameDecoder
* 继承LengthFieldBasedFrameDecoder通用半包解码器
* 继承ByteToMessageDecoder自己处理半包消息