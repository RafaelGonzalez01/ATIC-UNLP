PA EQU 30h 
CA EQU 32h 
org 1000h
msjt db "llaves prendidas" 
msjf db "llaves apagadas"
finmsj db ?
ORG 2000h 
       mov al, 0ffh 
       out CA, al
       in al, PA
       and al, 10000000b
       cmp al, 10000000b
       jnz false
       mov bx, offset msjt
       mov al, offset msjf - offset msjt 
       jmp fin
false: mov bx, offset msjf
       mov al, offset finmsj - offset msjf
fin:   int 7
       hlt     
       end 