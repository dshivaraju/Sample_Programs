image: driver.o image_copy.o
	gcc -o image driver.o image_copy.o

driver.o: driver.c
	gcc -c -Wall driver.c

image_copy.o: image_copy.c
	gcc -c -Wall image_copy.c

clean:
	rm -rf *.o image