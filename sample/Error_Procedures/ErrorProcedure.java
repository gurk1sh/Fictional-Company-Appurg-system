package sample.Error_Procedures;

public class ErrorProcedure {
        private String title;
        private String info;
        private String machine;

        public ErrorProcedure()
        {

        }

        public ErrorProcedure(String newTitle, String newInfo, String newMachine)
        {
            this.title = newTitle;
            this.info = newInfo;
            this.machine = newMachine;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getMachine() {
            return machine;
        }

        public void setMachine(String machine) {
            this.machine = machine;
        }

}
