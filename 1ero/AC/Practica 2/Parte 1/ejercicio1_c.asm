PA EQU 30h 
PB EQU 31h 
CA EQU 32h 
CB EQU 33h 
ORG 2000h 
mov al, 0ffh 
out CA, al
mov al, 0b
out CB, al 
in al, PA 
out PB, al 
int 0 
end 