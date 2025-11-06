package DataSet;

public class Item {
    private String texto;
    private boolean isHeader;

    public Item(String texto, boolean isHeader) {
        this.texto = texto;
        this.isHeader = isHeader;
    }

    public String toString() {
        return texto;
    }


    public void setHeader(boolean header) {
        isHeader = header;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isHeader() {
        return isHeader;
    }
}
