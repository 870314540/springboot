package lucenetest;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.fst.Builder;
import org.apache.lucene.util.fst.FST;
import org.apache.lucene.util.fst.PositiveIntOutputs;
import org.apache.lucene.util.fst.Util;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/1/14
 */
public class TestFst {

    //https://www.jianshu.com/p/a7d7092fba02
    @Test
    public void TestFst() {
        try {

            Directory directory = FSDirectory.open(Paths.get(new File("E:\\Lucene_index").getPath()));

            System.out.println("pathname"+Paths.get(new File("E:\\Lucene_index").getPath()));



            SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer();



        } catch (Exception e) {

        }
    }
}
