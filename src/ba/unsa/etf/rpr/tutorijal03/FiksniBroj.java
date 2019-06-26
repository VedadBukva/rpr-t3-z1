package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {
    public FiksniBroj(Grad grad, String broj) {
        this.grad=grad;
        this.broj=broj;
    }

    private Grad grad;
    private String broj;

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) { this.broj = broj;
    }


        public enum Grad{
        TRAVNIK, ORASJE, ZENICA, SARAJEVO, LIVNO, TUZLA, MOSTAR, BIHAC, GORAZDE, SIROKIBRIJEG,
        MRKONJICGRAD, BANJALUKA, PRIJEDOR, DOBOJ, SAMAC, BIJELJINA, ZVORNIK, PALE, FOCA, TREBINJE
    }

    @Override
    public String ispisi() {
        String ispis="";
        switch (grad)
        {
            case TRAVNIK:
                ispis+="030/";
                break;
            case ORASJE:
                ispis+="031/";
                break;
            case ZENICA:
                ispis+="032/";
                break;
            case SARAJEVO:
                ispis+="033/";
                break;
            case LIVNO:
                ispis+="034/";
                break;
            case TUZLA:
                ispis+="035/";
                break;
            case MOSTAR:
                ispis+="036/";
                break;
            case BIHAC:
                ispis+="037/";
                break;
            case GORAZDE:
                ispis+="038/";
                break;
            case SIROKIBRIJEG:
                ispis+="039/";
                break;
            case MRKONJICGRAD:
                ispis+="050/";
                break;
            case BANJALUKA:
                ispis+="051/";
                break;
            case PRIJEDOR:
                ispis+="052/";
                break;
            case DOBOJ:
                ispis+="053/";
                break;
            case SAMAC:
                ispis+="054/";
                break;
            case BIJELJINA:
                ispis+="055/";
                break;
            case ZVORNIK:
                ispis+="056/";
                break;
            case PALE:
                ispis+="057/";
                break;
            case FOCA:
                ispis+="058/";
                break;
            case TREBINJE:
                ispis+="059/";
                break;
            default:
                ispis+="?";
                break;
        }
        ispis+=broj;
        return ispis;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
