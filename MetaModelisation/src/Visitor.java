/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulohenriquefaveropereira
 */
public interface Visitor {
    
    public void visitIntExp(IntExp e);

    public void visitAddExp(AddExp e);

    public void visitMultExp(MultExp e);
}
