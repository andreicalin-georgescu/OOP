package Implementations;

/**
 * Clasa folosita pentru a vedea daca media numarului de ore suplimentare pentru angajati
 * este mai mare decat cea a managerilor.
 */
public class MostHardworkingEmployeeFinder implements Visitor {

    private int empHrs;
    private int manHrs;
    private int nrEmp;
    private int nrMan;

    @Override
    public void visit(Employee employee) {
        //TODO
        empHrs += employee.getExtraHours();
        nrEmp ++;
    }

    @Override
    public void visit(Manager manager) {
        //TODO
        manHrs += manager.getExtraHours();
        nrMan ++;
    }

    @Override
    public void visit(Intern intern) {
        //do nothing
    }

    public boolean isManagerHardWorking() {
        //TODO

        return manHrs / nrMan > empHrs / nrEmp;
    }
}
