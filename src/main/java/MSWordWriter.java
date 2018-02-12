import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MSWordWriter implements Writer {

    private XWPFDocument document;
    private FileOutputStream output;

    public MSWordWriter(String filename){
        this.document = new XWPFDocument();

        try {
            this.output = new FileOutputStream(new File(filename + ".docx"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeInFile(String message) {
        XWPFParagraph paragraph = this.document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setFontFamily("Arial");
        run.setFontSize(12);
        run.setText(message);
        try {
            document.write(output);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            output.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
