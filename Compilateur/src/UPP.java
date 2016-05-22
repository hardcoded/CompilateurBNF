import java.util.*;

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class UPPExpr {}//UPPExpr

class UPPCte extends UPPExpr {

    int val;

    UPPCte (int val) {
        this.val = val;
    }//UPPCte
    
    public String toString() {
    	return Integer.toString(val);
    }
}//UPPCte

class UPPTrue extends UPPExpr {}//UPPTrue

class UPPFalse extends UPPExpr {}//UPPFalse

class UPPVar extends UPPExpr {

    String name;

    UPPVar (String name) {
        this.name = name;
    }//UPPVar

    public String toString() {
    	String res = "local " + this.name;
    	return res;
    }
}//UPPVar

class UPPGVar extends UPPExpr {

    String name;

    UPPGVar (String name) {
        this.name = name;
    }//UPPGVar

    public String toString() {
    	String res = "global " + this.name;
    	return res;
    }
}//UPPGVar

abstract class UPPUnOp extends UPPExpr {

    UPPExpr e;

}//UPPUnOp

class UPPNot extends UPPUnOp {

    UPPNot (UPPExpr e) {
        this.e = e;
    }//UPPNot

    public String toString() {
    	String res = "not " + this.e.toString();
    	return res;
    }
}//UPPNot

abstract class UPPBinOp extends UPPExpr {

    UPPExpr e1, e2;

}//UPPBinOp

class UPPAdd extends UPPBinOp {

    UPPAdd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAdd

    public String toString() {
    	String res = this.e1.toString() + " + " + this.e2.toString();
    	return res;
    }
}//UPPAd

class UPPSub extends UPPBinOp {

    UPPSub (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPSub

    public String toString() {
    	String res = this.e1.toString() + " - " + this.e2.toString();
    	return res;
    }
}//UPPSub

class UPPMul extends UPPBinOp {

    UPPMul (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPMul

    public String toString() {
    	String res = this.e1.toString() + " * " + this.e2.toString();
    	return res;
    }
}//UPPMul

class UPPDiv extends UPPBinOp {

    UPPDiv (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPDiv

    public String toString() {
    	String res = this.e1.toString() + " / " + this.e2.toString();
    	return res;
    }
}//UPPDiv

class UPPAnd extends UPPBinOp {

    UPPAnd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAnd

    public String toString() {
    	String res = this.e1.toString() + " and " + this.e2.toString();
    	return res;
    }
}//UPPAnd

class UPPOr extends UPPBinOp {

    UPPOr (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPOr

    public String toString() {
    	String res = this.e1.toString() + " or " + this.e2.toString();
    	return res;
    }
}//UPPOr

class UPPLe extends UPPBinOp {

    UPPLe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLe

    public String toString() {
    	String res = this.e1.toString() + " < " + this.e2.toString();
    	return res;
    }
}//UPPLe

class UPPLeq extends UPPBinOp {

    UPPLeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLeq

    public String toString() {
    	String res = this.e1.toString() + " <= " + this.e2.toString();
    	return res;
    }
}//UPPLeq

class UPPEq extends UPPBinOp {

    UPPEq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPEq

    public String toString() {
    	String res = this.e1.toString() + " = " + this.e2.toString();
    	return res;
    }
}//UPPEq

class UPPNeq extends UPPBinOp {

    UPPNeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPNeq

    public String toString() {
    	String res = this.e1.toString() + " != " + this.e2.toString();
    	return res;
    }
}//UPPNeq

class UPPGeq extends UPPBinOp {

    UPPGeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGeq

    public String toString() {
    	String res = this.e1.toString() + " >= " + this.e2.toString();
    	return res;
    }
}//UPPGeq

class UPPGe extends UPPBinOp {

    UPPGe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGe

    public String toString() {
    	String res = this.e1.toString() + " > " + this.e2.toString();
    	return res;
    }
}//UPPGe

class Alloc extends Callee {}//Alloc

class UPPFunCall extends UPPExpr {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPFunCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall

    public String toString() {
    	String res = this.callee.toString() + " ( ";
    	for(UPPExpr arg : args) {
    		res += arg.toString();
    		res += ", ";
    	}
    	res += ")";
    	return res;
    }
}//FunCall

class UPPLoad extends UPPExpr {

    UPPExpr addr;

    UPPLoad (UPPExpr addr) {
        this.addr = addr;
    }//UPPLoad

    //TODO: add toString() method
}//UPPLoad

/****************/
/* Instructions */
/****************/

abstract class UPPInst {}//UPPInst

class UPPAssign extends UPPInst {

    String name;
    UPPExpr val;

    UPPAssign (String name, UPPExpr val) {
        this.name = name;
        this.val = val;
    }//UPPAssign

    public String toString() {
    	String res = this.name + " := " + this.val.toString();
    	return res;
    }
}//UPPAssign

class UPPStore extends UPPInst {

    UPPExpr addr, val;

    UPPStore (UPPExpr addr, UPPExpr val) {
        this.addr = addr;
        this.val = val;
    }//UPPStore

    //TODO: add toString() method
}//UPPStore

class UPPCond extends UPPInst {

    UPPExpr cond;
    UPPInst i1, i2;

    UPPCond (UPPExpr cond, UPPInst i1, UPPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//UPPCond

    public String toString() {
    	String res = "if" + this.cond.toString() + " then " + this.i1.toString() + "else" + this.i2.toString();
    	return res;
    }
}//UPPCond

class UPPWhile extends UPPInst {

    UPPExpr cond;
    UPPInst i;

    UPPWhile (UPPExpr cond, UPPInst i) {
        this.cond = cond;
        this.i = i;
    }//UPPWhile

    public String toString() {
    	String res = "while" + this.cond.toString() + "do" + this.i.toString();
    	return res;
    }
}//UPPWhile

class UPPProcCall extends UPPInst {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPProcCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//UPPProcCall

    //TODO: add toString() method
}//UPPProcCall
    
class UPPSkip extends UPPInst {
	public String toString() {
		String res = "skip";
		return res;
	}
}//UPPSkip

class UPPSeq extends UPPInst {

    UPPInst i1, i2;

    UPPSeq (UPPInst i1, UPPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//UPPSeq

}//UPPSeq

/***************************************/
/* Definitions of functions/procedures */
/***************************************/

abstract class UPPDef {

    String name;
    ArrayList<String> args, locals;
    UPPInst code;

}//UPPDef

class UPPFun extends UPPDef {

    UPPFun (String name, ArrayList<String> args, ArrayList<String> locals,
            UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPFun

    public String toString() {
    	String res = this.name + " ( ";
    	for(String arg : args) {
    		res += arg;
    		res += ",";
    	}
    	for(String local : locals) {
    		res += "var " + local;
    		res += "\n";
    	}
    	res += this.code.toString();
    	return res;
    }
}//UPPFun

class UPPProc extends UPPDef {

    UPPProc (String name, ArrayList<String> args, ArrayList<String> locals,
             UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPProc

}//UPPProc

/************/
/* Programs */
/************/

class UPPProg {

    ArrayList<String> globals;
    ArrayList<UPPDef> defs;
    UPPInst code;

    UPPProg (ArrayList<String> globals, ArrayList<UPPDef> defs, UPPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//UPPProg

}//UPPProg
