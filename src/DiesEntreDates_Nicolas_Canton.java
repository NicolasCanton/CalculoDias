public class DiesEntreDates_Nicolas_Canton extends CalcularDiesEntreDates{
    int diasMes;
    boolean añoBisiesto;
    public DiesEntreDates_Nicolas_Canton() {
    }
    @Override
    protected int diesMes(int Mes) {
        switch (Mes){
            case 1,3,5,7,8,10,12->{
                this.diasMes= 31;
            }
            case 2->{
                this.diasMes=28;
            }
            case 4,6,9,11->{
                this.diasMes= 30;
            }
        }
        return this.diasMes;
    }
    @Override
    protected int diesMesInicial(DataXS dataXS) {
        return diesMes(dataXS.mes)-dataXS.dia;
    }
    @Override
    protected int diesMesDesti(DataXS dataXS) {
        return dataXS.dia;
    }
    @Override
    protected int diesResteAnyInicial(DataXS datainicial) {
        int dias=0;
        for (int i = 0; i < 12-datainicial.mes; i++) {
            dias+=diesMes(datainicial.mes+i);
        }
        return dias;
    }
    @Override
    protected int diesResteAnyDesti(DataXS datadesti) {
        int dias=0;
        for (int i = 0; i < (datadesti.mes-1); i++) {
            dias+=diesMes(datadesti.mes-i);
        }
        return dias;
    }
    @Override
    protected int diesNumAnysComplets(DataXS datainicial, DataXS datadesti) {
        return 365*((datadesti.any-datainicial.any)-1);
    }
    @Override
    protected int numDiesPerAnysdeTraspas(DataXS datainicial, DataXS datadesti) {
        int diasExtra=0;
        for (int i = 0; i <= ((datadesti.any-datainicial.any)-1); i++) {
            if (anyDeTraspas(datainicial.any+i)){
                diasExtra++;
            }
        }
        if(anyDeTraspas(datadesti.any)){
            diasExtra++;
        }
        return diasExtra;
    }
    @Override
    protected boolean anyDeTraspas(int any) {
        if ((any % 400 == 0) || ((any % 4 == 0) && !(any % 100 == 0))){
            añoBisiesto= true;
        }else{
            añoBisiesto=false;
        }
        return añoBisiesto;
    }
}
