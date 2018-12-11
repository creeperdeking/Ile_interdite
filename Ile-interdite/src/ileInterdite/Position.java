/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileInterdite;

/**
 *
 * @author grosa
 */
public class Position {
    public final int x;
    public final int y;
    
    /**
     * On définit le constructeur de Position avec un integer x et un integer y
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * On vérifie si une position correspond à une autre
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object)
    {
        boolean isEqual= false;

        if (object != null && object instanceof Position)
        {
            isEqual = (this.x == ((Position) object).x && this.y == ((Position) object).y);
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.x;
    }
}
