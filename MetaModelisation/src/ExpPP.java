/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulohenriquefaveropereira
 */
public class ExpPP  implements Visitor{

      String output = "";
    
   public void visitIntExp(IntExp e)
    {
    output += e.getVal().toString();
    }
    
   public void visitAddExp(AddExp e)
    {
    e.op1.accept(this);
    output += "+";
    e.op2.accept(this);
    }

    @Override
    public void visitMultExp(MultExp e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
