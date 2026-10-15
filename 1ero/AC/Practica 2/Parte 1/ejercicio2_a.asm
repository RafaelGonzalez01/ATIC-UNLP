PB EQU 31h 
CB EQU 33h 
ORG 2000h 
mov al, 0b 
out CB, al
mov al, 11000011b
out PB, al 
int 0 
end 