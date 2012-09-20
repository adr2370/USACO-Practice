{
ID:think_e1
PROG:checker
LANG:PASCAL
}
var n,aim,sum:longint;
      path:array[1..13]of longint;
 procedure test(row,ld,rd,t:longint);
 var pos,p,nn,tt,i:longint;
  begin
     if row<>aim then
      begin
       pos:=aim and not(row or ld or rd);
       while pos<>0 do
        begin
          p:=pos and -pos;
          pos:=pos-p;
        nn:=p;tt:=0;while nn<>0 do begin nn:=nn shr 1;inc(tt);end;
          path[t]:=tt;
          test(row+p,(ld+p) shl 1,(rd+p)shr 1,t+1);
        end;
      end
     else
      begin
      inc(sum);
       if sum<=3 then
        begin
          for i:=1 to n-1 do
           write(path[i],' ');writeln(path[n]);
        end;
     end;
  end;
 begin
  assign(input,'checker.in');reset(input);
  assign(output,'checker.out');rewrite(output);
  readln(n);
  aim:=1 shl n -1;
  test(0,0,0,1);
  writeln(sum);
  close(input);close(output);
 end.
