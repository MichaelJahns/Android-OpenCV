#include "opencv-utils.h"
#include <opencv2/imgproc.hpp>
#include <opencv2/highgui.hpp>

void myFlip(Mat src) {
    flip(src, src, 0);
}

void myBlur(Mat src, float sigma) {
    GaussianBlur(src, src, Size(), sigma);
}

void myGrayScale(Mat src) {
    cvtColor(src, src, COLOR_BGR2GRAY);
}

void myAutumnColorMap(Mat src) {
    applyColorMap(src, src, COLORMAP_AUTUMN);
}