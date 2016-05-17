// BNF.g4

grammar BNF;

//---------------------------------------------------------------------
variable : integerExpr | booleanExpr | arrayExpr;

//CONST : NUMBER | BOOLEAN;

call : CALL variable;

expr : CONST | STRING | negatif |
          notExpr | boolExpr
          add | comparaison |
          call | expr CROO expr CROF |
          TYPE tableau;

instruc : STRING AFFECT expr | expr AFFECT expr |
                    IF expr THEN expr ELSE expr |
                    WHILE expr DO instruc
                     call |
                     SKIP |
                     instruc SEMICOL instruc;

func : FUNC PARO (STRING ':' TYPE)* PARF option;
option :  | ':' TYPE;

prog : VAR (STRING ':' TYPE)*
          func*
          instruc;

// --------------------------Arithmétique--------------------------
comparaison : NUMBER ARITHEXPR NUMBER;
// nombre négatifs
negatif : PARO NEG NUMBER PARF

// Addition and subtraction have the lowest precedence.
add : mult (ADD mult | ADD mult)* ;

// Multiplication and division have a higher precedence.
mult : atomExpr (MULT atomExpr | MULT atomExpr)* ;

/* An expression atom is the smallest part of an expression: a number. Or
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExpr'. As you can see, an 'atomExpr' has the highest
   precedence. */
atomExpr : NUMBER | PARO add PARF | negatif ;

// Tableaux
tableau : STRING CROO (NUMBER | BOOLEAN | tableau) CROF

//-----------------boolean-------------------------

//Les expressions booleennes :
boolExpr : orExpr;

// Les and et les or ont une faible precedence.
orExpr :  andExpr (OR andExpr)*;
andExpr :  (atomBooleanExpr | notExpr) (AND (atomBooleanExpr | notExpr))*;

// les not ont une forte precedence.
notExpr : NOT atomBoolExpr;

atomBoolExpr : (booleanElement  | orExpr);

// Les comparaisons ont la plus grande precedence.
booleanElement : (BOOLEAN | comparaison);


// Lexing rules
LETTER : ('a'..'z' | 'A'..'Z')+;
STRING : LETTER*;
NUMBER : ('0'..'9')+;
BOOLEAN : ( 'true' | 'false' );
CONST : NUMBER | BOOLEAN;
TYPE : ( 'number' | 'boolean' |'new' 'array of' );
NEG : '-';
NOT : ( 'not' | '!' );
ARITHEXPR : ( '<' | '<=' | '=' | '!=' | '>=' | '>' );
ADD : ( '+' | '-' );
 MULT : ('*' | '/' );
AND : 'and';
OR : 'or';
WHILE : 'while';
DO :'do';
IF : 'if';
THEN : 'then';
ELSE : 'else';
VAR : 'var';
AFFECT : ':=';
CROO :  '[';
CROF : ']';
PARO : ( '(' );
PARF : (' )' );
SEMICOL : ';';
FUNC : 'f'
CALL : ( 'read' | ' write'  | FUNC);
SKIP : ('skip');
// We're going to ignore all white space characters
WS : [ \t\r\n]+ -> skip;
