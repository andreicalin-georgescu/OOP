package Implementations;

/**
 * Clasa folosita pentru a parcurge o structura ierarhica / arborescenta - separa doua
 * concepte: un obiect de tipul visitor ce realizeaza operatii pe un set de date
 * (ex. calculeaza media orelor suplimentare) si acest tip de visitor (TreeVisitor)
 * ce parcurge nodurile structurii arborescente si aplica visitor-ul ce realizeaza operatii
 * (prezentat anterior).
 */
public class TreeVisitor implements Visitor {

    private Visitor baseVisitor;

    public TreeVisitor(Visitor baseVisitor) {
        this.baseVisitor = baseVisitor;
    }

    @Override
    public void visit(Employee employee) {
        //TODO
        employee.accept(baseVisitor);
    }

    @Override
    public void visit(Manager manager) {
        //TODO
        for (Visitable visitable : manager.getSubordinates()) {
            visitable.accept(this);
        }
        manager.accept(baseVisitor);
    }

    @Override
    public void visit(Intern intern) {
        intern.accept(baseVisitor);
    }

    public Visitor getBaseVisitor() {
        return baseVisitor;
    }
}