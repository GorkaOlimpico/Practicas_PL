package c_ast_ascendente;


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
  return ops.token(ClaseLexica.EOF);
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
eof = \<EOF\>

cadena = \" ([^\n\b\r]*) \"

%%
{separador}               {}
{comentario}              {}

{int}                     {return ops.token(ClaseLexica.r_int);}
{real}                    {return ops.token(ClaseLexica.r_real);}
{bool}                    {return ops.token(ClaseLexica.r_bool);}
{true}                    {return ops.token(ClaseLexica.r_true);}
{false}                   {return ops.token(ClaseLexica.r_false);}
{and}                     {return ops.token(ClaseLexica.r_and);}
{or}                      {return ops.token(ClaseLexica.r_or);}
{not}                     {return ops.token(ClaseLexica.r_not);}
{string}                  {return ops.token(ClaseLexica.r_string);}
{null}                    {return ops.token(ClaseLexica.r_null);}
{proc}                    {return ops.token(ClaseLexica.r_proc);}
{if}                      {return ops.token(ClaseLexica.r_if);}
{then}                    {return ops.token(ClaseLexica.r_then);}
{else}                    {return ops.token(ClaseLexica.r_else);}
{endif}                   {return ops.token(ClaseLexica.r_endif);}
{while}                   {return ops.token(ClaseLexica.r_while);}
{do}                      {return ops.token(ClaseLexica.r_do);}
{endwhile}                {return ops.token(ClaseLexica.r_endwhile);}
{call}                    {return ops.token(ClaseLexica.r_call);}
{record}                  {return ops.token(ClaseLexica.r_record);}
{array}                   {return ops.token(ClaseLexica.r_array);}
{of}                      {return ops.token(ClaseLexica.r_of);}
{pointer}                 {return ops.token(ClaseLexica.r_pointer);}
{new}                     {return ops.token(ClaseLexica.r_new);}
{del}                     {return ops.token(ClaseLexica.r_del);}
{read}                    {return ops.token(ClaseLexica.r_read);}
{write}                   {return ops.token(ClaseLexica.r_write);}
{nl}                      {return ops.token(ClaseLexica.r_nl);}
{var}                     {return ops.token(ClaseLexica.r_var);}
{type}                    {return ops.token(ClaseLexica.r_type);}

{identificador}             {return ops.token(ClaseLexica.id);}
{numeroEntero}           	{return ops.token(ClaseLexica.lit_int);}
{numeroReal}           		{return ops.token(ClaseLexica.lit_real);}
{cadena}                  	{return ops.token(ClaseLexica.lit_cad);}

{operadorMas}             {return ops.token(ClaseLexica.mas);}
{operadorMenos}           {return ops.token(ClaseLexica.menos);}
{operadorPor}             {return ops.token(ClaseLexica.por);}
{operadorDiv}             {return ops.token(ClaseLexica.div);}
{operadorMod}             {return ops.token(ClaseLexica.mod);}
{parentesisApertura}      {return ops.token(ClaseLexica.pap);}
{parentesisCierre}        {return ops.token(ClaseLexica.pcierre);}
{corcheteApertura}        {return ops.token(ClaseLexica.cap);}
{corcheteCierre}          {return ops.token(ClaseLexica.ccierre);}
{llaveApertura}           {return ops.token(ClaseLexica.llap);}
{llaveCierre}             {return ops.token(ClaseLexica.llcierre);}
{asignacion}              {return ops.token(ClaseLexica.asig);}
{coma}                    {return ops.token(ClaseLexica.coma);}
{punto}                   {return ops.token(ClaseLexica.punto);}
{pto_coma}                {return ops.token(ClaseLexica.pto_coma);}
{blt}                     {return ops.token(ClaseLexica.blt);}
{ble}                     {return ops.token(ClaseLexica.ble);}
{bgt}                     {return ops.token(ClaseLexica.bgt);}
{bge}                     {return ops.token(ClaseLexica.bge);}
{beq}                     {return ops.token(ClaseLexica.beq);}
{bne}                     {return ops.token(ClaseLexica.bne);}
{flecha}                  {return ops.token(ClaseLexica.flecha);}
{et}                      {return ops.token(ClaseLexica.et);}
{separadorPrograma}       {return ops.token(ClaseLexica.sep_prog);}
{eof}                     {return ops.token(ClaseLexica.EOF);}
[^]                       {errores.errorLexico(fila(),lexema());}