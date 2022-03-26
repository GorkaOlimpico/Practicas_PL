package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEOF();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = ({digitoPositivo}{digito}*|0)
numeroEntero = [\+\-]?{parteEntera}							
parteDecimal = \.({digito}* {digitoPositivo}|0)
parteExponencial = (e|E) {numeroEntero}
numeroReal = {numeroEntero}({parteExponencial}|{parteDecimal}{parteExponencial}|{parteDecimal})

separador = [ \t\r\b\n]
comentario = #[^\n]*
 
int = int
real = real
bool = bool
true = true
false = false
and = and
or = or
not = not
string = string
null = null
proc = proc
if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
call = call
record = record
array = array
of = of
pointer = pointer
new = new
del = del
read = read
write = write
nl = nl
var = var
type = type

identificador = {letra}({letra}|{digito}|\_)*				

operadorMas = \+
operadorMenos = \-
operadorPor = \*
operadorDiv = \/
operadorMod = \%
parentesisApertura = \(
parentesisCierre = \)
corcheteApertura = \[
corcheteCierre = \]
llaveApertura = \{
llaveCierre  =\}
asignacion = \=
coma  = \,
punto = \.
pto_coma = \;
blt = \<
ble = \<\=
bgt = \>
bge = \>\=
beq = \=\=
bne = \!\=
flecha = \-\>
et = \&
separadorPrograma = \&\&
eof = eof

%%
{separador}               {}
{comentario}              {}

{int}                     {return ops.unidadINT();}
{real}                    {return ops.unidadREAL();}
{bool}                    {return ops.unidadBOOL();}
{true}                    {return ops.unidadTRUE();}
{false}                   {return ops.unidadFALSE();}
{and}                     {return ops.unidadAND();}
{or}                      {return ops.unidadOR();}
{not}                     {return ops.unidadNOT();}
{string}                  {return ops.unidadSTRING();}
{null}                    {return ops.unidadNULL();}
{proc}                    {return ops.unidadPROC();}
{if}                      {return ops.unidadIF();}
{then}                    {return ops.unidadTHEN();}
{else}                    {return ops.unidadELSE();}
{endif}                   {return ops.unidadENDIF();}
{while}                   {return ops.unidadWHILE();}
{do}                      {return ops.unidadDO();}
{endwhile}                {return ops.unidadENDWHILE();}
{call}                    {return ops.unidadCALL();}
{record}                  {return ops.unidadRECORD();}
{array}                   {return ops.unidadARRAY();}
{of}                      {return ops.unidadOF();}
{pointer}                 {return ops.unidadPOINTER();}
{new}                     {return ops.unidadNEW();}
{del}                     {return ops.unidadDEL();}
{read}                    {return ops.unidadREAD();}
{write}                   {return ops.unidadWRITE();}
{nl}                      {return ops.unidadNL();}
{var}                     {return ops.unidadVAR();}
{type}                    {return ops.unidadTYPE();}

{identificador}             {return ops.unidadID();}
{numeroEntero}           	{return ops.unidadLIT_INT();}
{numeroReal}           		{return ops.unidadLIT_REAL();}

{operadorMas}             {return ops.unidadMAS();}
{operadorMenos}           {return ops.unidadMENOS();}
{operadorPor}             {return ops.unidadPOR();}
{operadorDiv}             {return ops.unidadDIV();}
{operadorMod}             {return ops.unidadMOD();}
{parentesisApertura}      {return ops.unidadPAP();}
{parentesisCierre}        {return ops.unidadPCIERRE();}
{corcheteApertura}        {return ops.unidadCAP();}
{corcheteCierre}          {return ops.unidadCCIERRE();}
{llaveApertura}           {return ops.unidadLLAP();}
{llaveCierre}             {return ops.unidadLLCIERRE();}
{asignacion}              {return ops.unidadASIG();}
{coma}                    {return ops.unidadCOMA();}
{punto}                   {return ops.unidadPUNTO();}
{pto_coma}                {return ops.unidadPTO_COMA();}
{blt}                     {return ops.unidadBLT();}
{ble}                     {return ops.unidadBLE();}
{bgt}                     {return ops.unidadBGT();}
{bge}                     {return ops.unidadBGE();}
{beq}                     {return ops.unidadBEQ();}
{bne}                     {return ops.unidadBNE();}
{flecha}                  {return ops.unidadFLECHA();}
{et}                      {return ops.unidadET();}
{separadorPrograma}       {return ops.unidadSEP_PROG();}
{eof}                     {return ops.unidadEOF();}
[^]                       {errores.errorLexico(fila(),lexema());}  