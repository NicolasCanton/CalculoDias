public class TestDiesEntreDates {
        private static DiesEntreDates_Nicolas_Canton calcul;
        private static DataXS inici, desti;

        public static void main(String[] args) {
            DiesEntreDates_Nicolas_Canton calcul = new DiesEntreDates_Nicolas_Canton();
            try {
                inici = new DataXS("30/12/1925");
                desti = new DataXS("10/09/2018");
                System.out.println(calcul.nombreDiesTotals(inici,desti));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

