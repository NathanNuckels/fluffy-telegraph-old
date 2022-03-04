import datetime
import sys
def log(txt):
	print(txt)
	with open("runlog.txt","w+") as f:
		f.write(txt+"\n")

if sys.argv[1]=="start":
	log(datetime.datetime.now())
	print("Starting program...\n")
if sys.argv[1]=="stop":
	print("\nProgram finished.")
	print("enter error code.")
	print("0. OK\n1. Compilation error\n2. Runtime crash\n3. Unexpected behavior")
	code=input("><>")
	code=int(code)
	if code==0:
		log("OK.")
	if code==1:
		log("COMPILER ERROR")
		log(input("What line number? ")+"\n")
	if code==2:
		log("UNHANDLED EXCEPTION")
	if code==3:
		log("UNEXPECTED BEHAVIOR")
print("Log written.")
