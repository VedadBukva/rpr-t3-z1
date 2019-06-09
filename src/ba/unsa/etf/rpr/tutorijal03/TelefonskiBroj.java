package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj>{

    public abstract String ispisi();

    public abstract int hashCode();

    @Override
    public int compareTo(TelefonskiBroj telefonskiBroj)
    {
        return this.ispisi().compareTo(telefonskiBroj.ispisi());
    }
}
