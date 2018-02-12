import java.io.*;

public class TextFileWriter implements Writer{

    private BufferedWriter output;

    public TextFileWriter(String filename){
        try {
            output = new BufferedWriter(new FileWriter(filename + ".txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeInFile(String message){
        if(output != null){
            try{
                output.write(message);
                output.flush();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void close(){
        if(output != null){
            try {
                output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
