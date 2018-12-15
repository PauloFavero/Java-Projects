
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulohenriquefaveropereira
 */
public class ExpMP implements Visitor {
    
    
      Stack stk = new Stack();
    
  public void visitIntExp(IntExp e)
    {
        stk.push(e);
    }

    public void visitAddExp(AddExp e) {
        
    e.op1.accept(this);
    e.op2.accept(this);
    
    IntExp2 = stk.pop();
    IntExp1 = stk.pop();
    }

    public void visitMultExp(MultExp e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

