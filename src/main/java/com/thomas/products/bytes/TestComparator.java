package com.thomas.products.bytes;

public class TestComparator {
//    RawComparator<IntWritable> comparator;
//    IntWritable w1;
//    IntWritable w2;
//
//    /**
//     * 获得IntWritable的comparator,并初始化两个IntWritable
//     */
//    @Before
//    public void init() {
//        comparator = WritableComparator.get(IntWritable.class);
//        w1 = new IntWritable(163);
//        w2 = new IntWritable(76);
//    }
//
//    /**
//     * 比较两个对象大小
//     */
//    @Test
//    public void testComparator() {
//        Assert.assertTrue(comparator.compare(w1, w2) > 0);
//    }
//
//    /**
//     * 序列号后进行直接比较
//     *
//     * @throws IOException
//     */
//    @Test
//    public void testcompare() throws IOException {
//        byte[] b1 = serialize(w1);
//        byte[] b2 = serialize(w2);
//        Assert.assertTrue(comparator.compare(b1, 0, b1.length, b2, 0, b2.length) > 0);
//    }
//
//    /**
//     * 将一个实现了Writable接口的对象序列化成字节流
//     *
//     * @param writable
//     * @return
//     * @throws java.io.IOException
//     */
//    public static byte[] serialize(Writable writable) throws IOException {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        DataOutputStream dataOut = new DataOutputStream(out);
//        writable.write(dataOut);
//        dataOut.close();
//        return out.toByteArray();
//    }
}
