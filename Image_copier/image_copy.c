#include<stdio.h>
#include<stdlib.h>
#include "image.h"

int copy_image(image* src,image* dest){

	if(src->actual_height>dest->max_height || src->actual_width>dest->max_width)
		return -1;

	for(int i=0;i<src->actual_height;i++){
		for(int j=0;j<src->actual_width;j++){
			dest->data[(i*dest->max_width)+j]=src->data[(i*src->max_width)+j];
		}
	}

	dest->actual_height=src->actual_height;
	dest->actual_width=src->actual_width;

	return 1;
}