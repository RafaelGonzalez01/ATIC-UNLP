PA EQU 30h 
PB EQU 31h
CA EQU 32h
CB EQU 33h
org 1000h

ORG 2000h 
       mov al, 0b 
       out CA, al
       mov al, 0ffh
       out CB, al
loop:  in al, PA
       out PB, al
       jmp loop
       hlt
       end 