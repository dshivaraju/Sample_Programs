#include<stdio.h>
#include<stdlib.h>
#include "image.h"

int main(){

	image src;
	image dest;
	src.max_width=12;
	src.max_height=14;
	dest.max_width=7;
	dest.max_height=6;
	src.actual_height=6;
	src.actual_width=7;

	//driver file to test image_copy function
	
	long *s=(long *)malloc(12*14*sizeof(long));
	long *d=(long *)malloc(7*6*sizeof(long));

	for(int i=0;i<src.actual_height;i++){
		for(int j=0;j<src.actual_width;j++){
			s[(i*src.max_width)+j]=(long)(i*src.max_width)+j;
		}
	}

	src.data=(void *)s;
	dest.data=(void *)d;

	//char* t1=(char *)s;
	/*for(int i=0;i<src.actual_height;i++){
		for(int j=0;j<src.actual_width;j++){
			printf("%d\n",s[(i*src.max_width)+j]);
			for(int k=0;k<4;k++){
				int offset=(((i*src.max_width)+j)*4)+k;
				printf("%d ",*(t1+offset));
			}
			printf("\n");
		}
	}
	printf("\n");*/

	int ret_code=copy_image(&src,&dest,sizeof(long));

	if(ret_code==-1){
		printf("error\n");
	}else{
		for(int i=0;i<dest.actual_height;i++){
			for(int j=0;j<dest.actual_width;j++){
				printf("%ld ",d[i*dest.actual_width+j]);
			}
			printf("\n");
		}
		printf("\n");
	}

	return 0;
}