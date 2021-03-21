# Ulam Spirals

Today I watched [this](https://www.youtube.com/watch?v=iFuR97YcSLM) Numberphile video about Ulam Spirals. I wanted to
visualize them. So I made this. It takes in two command-line arguments, a width followed by a height, then creates a png
of width by height size where each pixel represents a number in an Ulam spiral. The pixel is blue if the number is
prime, and transparent otherwise.

![sample spiral](./sample_out.png)

As you can see, it kind of makes diagonal lines.

It defaults to 1024x1024 for the image size.