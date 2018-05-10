import { Component, OnInit, style } from '@angular/core';

import { ModelService } from '../_services/index';
import { Word2Vec, ModelDto } from '../_models/index';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  models: any;

  modelDto: ModelDto = {
    description: "",
    name: "",
  }


  constructor(private modelService: ModelService) { }

  ngOnInit() {
    this.modelService.load()
    .subscribe(data => {
      this.models = data;
      console.log(this.models);
      
    });
  }

  addModel() {
    console.log(this.modelDto);
    
    if (this.modelDto.name.length > 3) {
      this.modelService.create(this.modelDto)
      .subscribe(data => {
        console.log(data);
      });
    }
    
    // if (this.models) {
    //   this.models.content.unshift({
    //     "name": "new model",
    //     "algorithm": "word2vec",
    //     "description": "was neues",
    //     "params": {
    //       "minWordFrequency": 5,
    //       "iterations": 5,
    //       "layerSize": 100,
    //       "seed": 43,
    //       "windowSize": 10
    //     },
    //     "modelUrl": "modelurl",
    //     "sourceUrls": [
    //       "sourceUrl1",
    //       "sourceUrl2"
    //     ],
    //     "id": "keineidichhab",
    //     "organization": "klaut-learning2"
    //   });

    // }
    
  }

}