package com.greek.text.auther;

import com.greek.text.user.Authors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveResponseForAuthor {
    private Authors isSavedAuthors;
}
