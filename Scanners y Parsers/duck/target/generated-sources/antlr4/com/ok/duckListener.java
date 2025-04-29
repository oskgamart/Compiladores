// Generated from com\ok\duck.g4 by ANTLR 4.9.2
package com.ok;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link duckParser}.
 */
public interface duckListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link duckParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(duckParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(duckParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(duckParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(duckParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(duckParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(duckParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#varDefID}.
	 * @param ctx the parse tree
	 */
	void enterVarDefID(duckParser.VarDefIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#varDefID}.
	 * @param ctx the parse tree
	 */
	void exitVarDefID(duckParser.VarDefIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#multipleVar}.
	 * @param ctx the parse tree
	 */
	void enterMultipleVar(duckParser.MultipleVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#multipleVar}.
	 * @param ctx the parse tree
	 */
	void exitMultipleVar(duckParser.MultipleVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#funcs}.
	 * @param ctx the parse tree
	 */
	void enterFuncs(duckParser.FuncsContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#funcs}.
	 * @param ctx the parse tree
	 */
	void exitFuncs(duckParser.FuncsContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#funcArguments}.
	 * @param ctx the parse tree
	 */
	void enterFuncArguments(duckParser.FuncArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#funcArguments}.
	 * @param ctx the parse tree
	 */
	void exitFuncArguments(duckParser.FuncArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#multipleFuncArguments}.
	 * @param ctx the parse tree
	 */
	void enterMultipleFuncArguments(duckParser.MultipleFuncArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#multipleFuncArguments}.
	 * @param ctx the parse tree
	 */
	void exitMultipleFuncArguments(duckParser.MultipleFuncArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(duckParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(duckParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterBodyStatement(duckParser.BodyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitBodyStatement(duckParser.BodyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(duckParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(duckParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(duckParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(duckParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(duckParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(duckParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePart(duckParser.ElsePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePart(duckParser.ElsePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterCycle(duckParser.CycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitCycle(duckParser.CycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(duckParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(duckParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#printExpresion}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpresion(duckParser.PrintExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#printExpresion}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpresion(duckParser.PrintExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#multiplePrint}.
	 * @param ctx the parse tree
	 */
	void enterMultiplePrint(duckParser.MultiplePrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#multiplePrint}.
	 * @param ctx the parse tree
	 */
	void exitMultiplePrint(duckParser.MultiplePrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(duckParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(duckParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#expresionFinal}.
	 * @param ctx the parse tree
	 */
	void enterExpresionFinal(duckParser.ExpresionFinalContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#expresionFinal}.
	 * @param ctx the parse tree
	 */
	void exitExpresionFinal(duckParser.ExpresionFinalContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(duckParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(duckParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#expFinal}.
	 * @param ctx the parse tree
	 */
	void enterExpFinal(duckParser.ExpFinalContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#expFinal}.
	 * @param ctx the parse tree
	 */
	void exitExpFinal(duckParser.ExpFinalContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(duckParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(duckParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#terminoFinal}.
	 * @param ctx the parse tree
	 */
	void enterTerminoFinal(duckParser.TerminoFinalContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#terminoFinal}.
	 * @param ctx the parse tree
	 */
	void exitTerminoFinal(duckParser.TerminoFinalContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(duckParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(duckParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#sumaResta}.
	 * @param ctx the parse tree
	 */
	void enterSumaResta(duckParser.SumaRestaContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#sumaResta}.
	 * @param ctx the parse tree
	 */
	void exitSumaResta(duckParser.SumaRestaContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#id_cte}.
	 * @param ctx the parse tree
	 */
	void enterId_cte(duckParser.Id_cteContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#id_cte}.
	 * @param ctx the parse tree
	 */
	void exitId_cte(duckParser.Id_cteContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#f_call}.
	 * @param ctx the parse tree
	 */
	void enterF_call(duckParser.F_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#f_call}.
	 * @param ctx the parse tree
	 */
	void exitF_call(duckParser.F_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#f_call_expresion}.
	 * @param ctx the parse tree
	 */
	void enterF_call_expresion(duckParser.F_call_expresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#f_call_expresion}.
	 * @param ctx the parse tree
	 */
	void exitF_call_expresion(duckParser.F_call_expresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#m_f_call_expresion}.
	 * @param ctx the parse tree
	 */
	void enterM_f_call_expresion(duckParser.M_f_call_expresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#m_f_call_expresion}.
	 * @param ctx the parse tree
	 */
	void exitM_f_call_expresion(duckParser.M_f_call_expresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link duckParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(duckParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link duckParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(duckParser.TypeContext ctx);
}