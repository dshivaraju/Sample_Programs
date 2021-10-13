typedef struct image{
	int max_height;
	int max_width;
	int actual_height;
	int actual_width;
	void* data;
}image;

int copy_image(image* src,image* dest,int datatype);