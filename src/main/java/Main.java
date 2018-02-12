public class Main {
    public static void main(String[] args) {
        Writer w = new MSWordWriter("Transcription");
        Receiver r = new Receiver();
        w.writeInFile(r.receiveString());
        w.close();
    }
}
