/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulohenriquefaveropereira
 */
public class BinExp extends Exp
{
    public Exp op1;
    public Exp op2;
    
    
    public BinExp(Exp op1, Exp op2)
    {
    
        this.op1 = op1;
        this.op2 = op2;
    }
    
}
