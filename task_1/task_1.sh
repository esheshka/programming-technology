#!/bin/bash

input_dir=$1
output_dir=$2

if [ ! -d "$output_dir" ]; then
    mkdir -p "$output_dir"
elif [ ! -e "$output_dir/*" ]; then
    rm $output_dir/*
fi

find "$input_dir" -type f | while read file; do
    filename=$(basename "$file")
    new_filename="$output_dir/$filename"
    
    if [ -f "$new_filename" ]; then
        extension="${filename##*.}"
        filename="${filename%.*}"
        counter=1
        while [ -f "$new_filename" ]; do
	    new_filename="$output_dir/${filename}_${counter}"
	    if [ "${extension}" != "${filename}" ]; then
		new_filename="${new_filename}.${extension}"
	    fi
	    counter=$((counter+1))
        done
    fi

    cp "$file" "$new_filename"
done
