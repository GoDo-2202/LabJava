/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Experience extends Candidates{
    private int expInYear;
    private String proSkill;

    public Experience() {
        super();
    }

    public Experience(int expInYear, String proSkill, int candidateId, String firstName, String lastName, int birthDate, String address, int number, String email, int candidateType) {
        super(candidateId, firstName, lastName, birthDate, address, number, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    
    

    public Experience(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    
    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
