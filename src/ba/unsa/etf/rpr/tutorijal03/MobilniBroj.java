package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj{
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) throws IllegalArgumentException {
        if(mobilnaMreza>67 || mobilnaMreza<60)throw new IllegalArgumentException("Neispravna mreža!");
        this.mobilnaMreza=mobilnaMreza;
        this.broj=broj;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String ispisi() {
        return "0"+mobilnaMreza+"/"+broj;
    }
}
