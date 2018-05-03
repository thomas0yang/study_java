package com.thomas.products.bytes;

public class TestWritable {
//    byte[] bytes = null;
//
//    /**
//     * 初始化一个IntWritable实例，并且调用系列化方法
//     *
//     * @throws IOException
//     */
//    @Before
//    public void init() throws IOException {
//        IntWritable writable = new IntWritable(163);
//        bytes = serialize(writable);
//    }
//
//    /**
//     * 一个IntWritable序列号后的四个字节的字节流 并且使用big-endian的队列排列
//     *
//     * @throws IOException
//     */
//    @Test
//    public void testSerialize() throws IOException {
//        Assert.assertEquals(bytes.length, 4);
//        Assert.assertEquals(StringUtils.byteToHexString(bytes), "000000a3");
//    }
//
//    /**
//     * 创建一个没有值的IntWritable对象，并且通过调用反序列化方法将bytes的数据读入到它里面 通过调用它的get方法，获得原始的值，163
//     */
//    @Test
//    public void testDeserialize() throws IOException {
//        IntWritable newWritable = new IntWritable();
//        deserialize(newWritable, bytes);
//        Assert.assertEquals(newWritable.get(), 163);
//    }
//
//    /**
//     * 将一个实现了Writable接口的对象序列化成字节流
//     *
//     * @param writable
//     * @return
//     * @throws IOException
//     */
//    public static byte[] serialize(Writable writable) throws IOException {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        DataOutputStream dataOut = new DataOutputStream(out);
//        writable.write(dataOut);
//        dataOut.close();
//        return out.toByteArray();
//    }
//
//    /**
//     * 将字节流转化为实现了Writable接口的对象
//     *
//     * @param writable
//     * @param bytes
//     * @return
//     * @throws IOException
//     */
//    public static byte[] deserialize(Writable writable, byte[] bytes) throws IOException {
//        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//        DataInputStream dataIn = new DataInputStream(in);
//        writable.readFields(dataIn);
//        dataIn.close();
//        return bytes;
//    }
}
