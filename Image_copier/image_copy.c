#include<stdio.h>
#include<stdlib.h>
#include "image.h"

int copy_image(image* src,image* dest,int size){

	//takes src image, dest image, size of datatype inside the src image and copies the contents of src image to dest image.
	// returns -1 for any error and 0 for success.

	if(src->actual_height>dest->max_height || src->actual_width>dest->max_width)  //check if dest image has enough space to copy contents
		return -1;
	
	char *s_c=(char *)src->data;
	char *d_c=(char *)dest->data;

	for(int i=0;i<src->actual_height;i++){      //do a byte copy irrespective of data type in the source image.
		for(int j=0;j<src->actual_width;j++){
			int dest_offset=((i*dest->max_width+j)*size);
			int src_offset=((i*src->max_width+j)*size);
			for(int k=0;k<size;k++){
				d_c[dest_offset+k]=s_c[src_offset+k];
			}
		}
	}

	dest->actual_height=src->actual_height;
	dest->actual_width=src->actual_width;

	return 1;
}