grammar duck;

// Reglas léxicas (tokens)
PROGRAM   : 'program';
MAIN      : 'main';
END       : 'end';
VAR       : 'var';
VOID      : 'void';
PRINT     : 'print';
WHILE     : 'while';
DO        : 'do';
IF        : 'if';
ELSE      : 'else';
INT_T     : 'int';
FLOAT_T   : 'float';
ASSIGN    : '=';
GT        : '>';
LT        : '<';
NE        : '!=';
SEMICOLON : ';';
COMMA     : ',';
COLON     : ':';
LPAREN    : '(';
RPAREN    : ')';
LBRACE    : '{';
RBRACE    : '}';
PLUS      : '+';
MINUS     : '-';
MULT      : '*';
DIV       : '/';

ID        : [a-zA-Z_][a-zA-Z_0-9]*;
CTE_INT   : [0-9]+;
CTE_FLOAT : [0-9]+ '.' [0-9]+;
CTE_STRING: '"' (~["\\] | '\\' .)* '"';

WS        : [ \t\r\n]+ -> skip;

LBRACKET: '[';
RBRACKET: ']';

// Reglas sintácticas (parser)
programa : PROGRAM ID SEMICOLON vars funcs MAIN body END ;

vars : VAR varDef | ;
varDef : ID varDefID COLON type SEMICOLON multipleVar ;
varDefID : COMMA ID varDefID | ;
multipleVar : varDef | ;

funcs : (func)* ;
func : VOID ID LPAREN funcArguments RPAREN LBRACKET vars body RBRACKET SEMICOLON ;
funcArguments : ID COLON type multipleFuncArguments | ;
multipleFuncArguments : COMMA funcArguments | ;

body : LBRACE bodyStatement RBRACE ;
bodyStatement : statement bodyStatement | ;

statement : assign
          | condition
          | cycle
          | f_call
          | print ;

assign : ID ASSIGN expresion SEMICOLON ;

condition : IF LPAREN expresion RPAREN body elsePart SEMICOLON ;
elsePart : ELSE body | ;

cycle : WHILE LPAREN expresion RPAREN DO body SEMICOLON ;

print : PRINT LPAREN printExpresion multiplePrint RPAREN SEMICOLON ;
printExpresion : expresion | CTE_STRING ;
multiplePrint : COMMA printExpresion multiplePrint | ;

expresion : exp expresionFinal ;
expresionFinal : GT exp
               | LT exp
               | NE exp
               | ;

exp : termino expFinal ;
expFinal : PLUS exp
         | MINUS exp
         | ;

termino : factor terminoFinal ;
terminoFinal : MULT termino
             | DIV termino
             | ;

factor : LPAREN expresion RPAREN
       | sumaResta id_cte ;

sumaResta : PLUS
          | MINUS
          | ;

id_cte : ID
       | CTE_INT
       | CTE_FLOAT ;

f_call : ID LPAREN f_call_expresion RPAREN SEMICOLON ;
f_call_expresion : expresion m_f_call_expresion
                 | ;
m_f_call_expresion : COMMA expresion m_f_call_expresion
                   | ;

type : INT_T | FLOAT_T ;
