/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulohenriquefaveropereira
 */
public class AddExp extends BinExp{

    public AddExp(Exp op1, Exp op2) {
        super(op1, op2);
    }
    

   public void accept(Visitor v)
    {
        v.visitAddExp();
        
    
    }
    
    
}
