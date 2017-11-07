// Generated from D:/IDEAProjects/excise1/src/main/java\hello.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link helloParser}.
 */
public interface helloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link helloParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(helloParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link helloParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(helloParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link helloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(helloParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link helloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(helloParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link helloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(helloParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link helloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(helloParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link helloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(helloParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link helloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(helloParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(helloParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(helloParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(helloParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(helloParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(helloParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(helloParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(helloParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(helloParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(helloParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link helloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(helloParser.IntContext ctx);
}