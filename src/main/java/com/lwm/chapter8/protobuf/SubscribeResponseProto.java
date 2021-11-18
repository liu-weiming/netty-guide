// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chapter8/SubscribeResponse.proto

package com.lwm.chapter8.protobuf;

public final class SubscribeResponseProto {
  private SubscribeResponseProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SubscribeResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:netty.SubscribeResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 subReqID = 1;</code>
     * @return The subReqID.
     */
    int getSubReqID();

    /**
     * <code>int32 respCode = 2;</code>
     * @return The respCode.
     */
    int getRespCode();

    /**
     * <code>string desc = 3;</code>
     * @return The desc.
     */
    java.lang.String getDesc();
    /**
     * <code>string desc = 3;</code>
     * @return The bytes for desc.
     */
    com.google.protobuf.ByteString
        getDescBytes();
  }
  /**
   * Protobuf type {@code netty.SubscribeResponse}
   */
  public static final class SubscribeResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:netty.SubscribeResponse)
      SubscribeResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use SubscribeResponse.newBuilder() to construct.
    private SubscribeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SubscribeResponse() {
      desc_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new SubscribeResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SubscribeResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              subReqID_ = input.readInt32();
              break;
            }
            case 16: {

              respCode_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              desc_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.lwm.chapter8.protobuf.SubscribeResponseProto.internal_static_netty_SubscribeResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.lwm.chapter8.protobuf.SubscribeResponseProto.internal_static_netty_SubscribeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.class, com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.Builder.class);
    }

    public static final int SUBREQID_FIELD_NUMBER = 1;
    private int subReqID_;
    /**
     * <code>int32 subReqID = 1;</code>
     * @return The subReqID.
     */
    @java.lang.Override
    public int getSubReqID() {
      return subReqID_;
    }

    public static final int RESPCODE_FIELD_NUMBER = 2;
    private int respCode_;
    /**
     * <code>int32 respCode = 2;</code>
     * @return The respCode.
     */
    @java.lang.Override
    public int getRespCode() {
      return respCode_;
    }

    public static final int DESC_FIELD_NUMBER = 3;
    private volatile java.lang.Object desc_;
    /**
     * <code>string desc = 3;</code>
     * @return The desc.
     */
    @java.lang.Override
    public java.lang.String getDesc() {
      java.lang.Object ref = desc_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        desc_ = s;
        return s;
      }
    }
    /**
     * <code>string desc = 3;</code>
     * @return The bytes for desc.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDescBytes() {
      java.lang.Object ref = desc_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        desc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (subReqID_ != 0) {
        output.writeInt32(1, subReqID_);
      }
      if (respCode_ != 0) {
        output.writeInt32(2, respCode_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(desc_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, desc_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (subReqID_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, subReqID_);
      }
      if (respCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, respCode_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(desc_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, desc_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse)) {
        return super.equals(obj);
      }
      com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse other = (com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse) obj;

      if (getSubReqID()
          != other.getSubReqID()) return false;
      if (getRespCode()
          != other.getRespCode()) return false;
      if (!getDesc()
          .equals(other.getDesc())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + SUBREQID_FIELD_NUMBER;
      hash = (53 * hash) + getSubReqID();
      hash = (37 * hash) + RESPCODE_FIELD_NUMBER;
      hash = (53 * hash) + getRespCode();
      hash = (37 * hash) + DESC_FIELD_NUMBER;
      hash = (53 * hash) + getDesc().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code netty.SubscribeResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:netty.SubscribeResponse)
        com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.lwm.chapter8.protobuf.SubscribeResponseProto.internal_static_netty_SubscribeResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.lwm.chapter8.protobuf.SubscribeResponseProto.internal_static_netty_SubscribeResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.class, com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.Builder.class);
      }

      // Construct using com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        subReqID_ = 0;

        respCode_ = 0;

        desc_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.lwm.chapter8.protobuf.SubscribeResponseProto.internal_static_netty_SubscribeResponse_descriptor;
      }

      @java.lang.Override
      public com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse getDefaultInstanceForType() {
        return com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.getDefaultInstance();
      }

      @java.lang.Override
      public com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse build() {
        com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse buildPartial() {
        com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse result = new com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse(this);
        result.subReqID_ = subReqID_;
        result.respCode_ = respCode_;
        result.desc_ = desc_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse) {
          return mergeFrom((com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse other) {
        if (other == com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse.getDefaultInstance()) return this;
        if (other.getSubReqID() != 0) {
          setSubReqID(other.getSubReqID());
        }
        if (other.getRespCode() != 0) {
          setRespCode(other.getRespCode());
        }
        if (!other.getDesc().isEmpty()) {
          desc_ = other.desc_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int subReqID_ ;
      /**
       * <code>int32 subReqID = 1;</code>
       * @return The subReqID.
       */
      @java.lang.Override
      public int getSubReqID() {
        return subReqID_;
      }
      /**
       * <code>int32 subReqID = 1;</code>
       * @param value The subReqID to set.
       * @return This builder for chaining.
       */
      public Builder setSubReqID(int value) {
        
        subReqID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 subReqID = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearSubReqID() {
        
        subReqID_ = 0;
        onChanged();
        return this;
      }

      private int respCode_ ;
      /**
       * <code>int32 respCode = 2;</code>
       * @return The respCode.
       */
      @java.lang.Override
      public int getRespCode() {
        return respCode_;
      }
      /**
       * <code>int32 respCode = 2;</code>
       * @param value The respCode to set.
       * @return This builder for chaining.
       */
      public Builder setRespCode(int value) {
        
        respCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 respCode = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearRespCode() {
        
        respCode_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object desc_ = "";
      /**
       * <code>string desc = 3;</code>
       * @return The desc.
       */
      public java.lang.String getDesc() {
        java.lang.Object ref = desc_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          desc_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string desc = 3;</code>
       * @return The bytes for desc.
       */
      public com.google.protobuf.ByteString
          getDescBytes() {
        java.lang.Object ref = desc_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          desc_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string desc = 3;</code>
       * @param value The desc to set.
       * @return This builder for chaining.
       */
      public Builder setDesc(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        desc_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string desc = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearDesc() {
        
        desc_ = getDefaultInstance().getDesc();
        onChanged();
        return this;
      }
      /**
       * <code>string desc = 3;</code>
       * @param value The bytes for desc to set.
       * @return This builder for chaining.
       */
      public Builder setDescBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        desc_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:netty.SubscribeResponse)
    }

    // @@protoc_insertion_point(class_scope:netty.SubscribeResponse)
    private static final com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse();
    }

    public static com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SubscribeResponse>
        PARSER = new com.google.protobuf.AbstractParser<SubscribeResponse>() {
      @java.lang.Override
      public SubscribeResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SubscribeResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SubscribeResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SubscribeResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.lwm.chapter8.protobuf.SubscribeResponseProto.SubscribeResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_netty_SubscribeResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_netty_SubscribeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n chapter8/SubscribeResponse.proto\022\005nett" +
      "y\"E\n\021SubscribeResponse\022\020\n\010subReqID\030\001 \001(\005" +
      "\022\020\n\010respCode\030\002 \001(\005\022\014\n\004desc\030\003 \001(\tB3\n\031com." +
      "lwm.chapter8.protobufB\026SubscribeResponse" +
      "Protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_netty_SubscribeResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_netty_SubscribeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_netty_SubscribeResponse_descriptor,
        new java.lang.String[] { "SubReqID", "RespCode", "Desc", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}