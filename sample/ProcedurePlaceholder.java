package sample;

import sample.Error_Procedures.ErrorProcedure;
import sample.Work_Procedures.WorkProcedure;

public final class ProcedurePlaceholder {

    private static ProcedurePlaceholder INSTANCE;

    private ErrorProcedure ep;

    private WorkProcedure wp;

    public static ProcedurePlaceholder getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ProcedurePlaceholder();
        }
        return INSTANCE;
    }

    private ProcedurePlaceholder() {
    }

    public void setProcedure(ErrorProcedure errorProcedure) {
        this.ep = errorProcedure;
    }

    public ErrorProcedure getProcedure() {
        return this.ep;
    }

    public WorkProcedure getWp() {
        return wp;
    }

    public void setWp(WorkProcedure workProcedure) {
        this.wp = workProcedure;
    }
}
