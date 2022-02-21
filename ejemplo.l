package alex;

%%
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}


SEP_PROG = &&
PTO_COMA = ;  ??????? hace falta poner \; ?????
INT = int
REAL = real
BOOL = bool
ASIG = \=
TRUE = true
FALSE = false
MAS = \+
MENOS = \-
POR = \*
DIV = /
NEG = \- ???????????????????????????????????????????????????? igual que el menos?
AND = and
OR = or
NOT = not
BLT = <
BGT = >
BLE = <=
BGE = >=
EQ = ==
NEQ = !=
PAP = \(
PCIERRE = \)

ID = {letra}({letra}|{digito}|{subrayado})*
letra = ([A-Z]|[a-z])
digito = [0-9]
subrayado = _

NUM_INT = [\+,\-]? {parteEntera}
NUM_REAL = {NUM_INT}\.{parteDecimal} {parteExp}?

parteEntera = {digitoPos}{digito}*
parteDecimal = \.({digito}*{digitoPositivo} | 0) ???? está bien????
digitoPos = [1-9]
parteExp = (e|E) parteEntera


SEP = [ \t\r\b\n]
COM = #[^\n,EOF]*


%%
{SEP}        			      {}
{COM}        			      {}

{SEP_PROG}					  {return ops.unidadSEP_PROG();}
{PTO_COMA}					  {return ops.unidadPTO_COMA();}
{INT}						  {return ops.unidadINT();}
{REAL}						  {return ops.unidadREAL();}
{BOOL}						  {return ops.unidadBOOL();}
{ASIG}						  {return ops.unidadASIG();}
{TRUE}					 	  {return ops.unidadTRUE();}
{FALSE}						  {return ops.unidadFALSE();}
{MAS}					      {return ops.unidadMAS();}
{MENOS}				 	      {return ops.unidadMENOS();}
{POR}				 		  {return ops.unidadPOR();}
{DIV}				          {return ops.unidadDIV();}
{NEG}				          {return ops.unidadNEG();}
{AND}				          {return ops.unidadAND();}
{OR}				          {return ops.unidadOR();}
{NOT}				          return ops.unidadNOT();}
{BLT}				          {return ops.unidadBLT();}
{BGT}				          {return ops.unidadBGT();}
{BLE}				          {return ops.unidadBLE();}
{BGE}				          {return ops.unidadBGE();}
{EQ}				          {return ops.unidadEQ();}
{NEQ}				          {return ops.unidadNEQ();}
{PAP}				          {return ops.unidadPAP();}
{PCIERRE}				      {return ops.unidadPCIERRE();}
{ID}				          {return ops.unidadID();}
{NUM_INT}				      {return ops.unidadNUM_INT();}
{NUM_REAL}				      {return ops.unidadNUM_REAL();}

[^]                           {ops.error();}  





