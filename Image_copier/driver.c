#include<stdio.h>
#include<stdlib.h>
#include "image.h"

int main(){

	image src;
	image dest;
	src.max_width=8;
	src.max_height=6;
	dest.max_width=4;
	dest.max_height=4;
	src.actual_height=3;
	src.actual_width=4;
	src.data=(int *)malloc(6*8*sizeof(int));
	dest.data=(int *)malloc(4*4*sizeof(int));

	for(int i=0;i<src.actual_height;i++){
		for(int j=0;j<src.actual_width;j++){
			src.data[(i*src.max_width)+j]=(i*src.max_width)+j;
		}
	}


	int ret_code=copy_image(&src,&dest);
	if(ret_code==-1){
		printf("error");
	}else{
		for(int i=0;i<dest.actual_height;i++){
			for(int j=0;j<dest.actual_width;j++){
				printf("%d ",dest.data[i*dest.actual_width+j]);
			}
		}
		printf("\n");
	}

	return 0;
}